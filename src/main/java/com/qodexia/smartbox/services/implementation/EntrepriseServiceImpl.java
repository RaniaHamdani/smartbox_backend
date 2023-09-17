package com.qodexia.smartbox.services.implementation;

import com.qodexia.smartbox.domains.Entreprise;
import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.enums.Roles;
import com.qodexia.smartbox.exceptions.BadRequestException;
import com.qodexia.smartbox.exceptions.RessourceNotFoundException;
import com.qodexia.smartbox.mapper.EntrepriseMapper;
import com.qodexia.smartbox.models.EntrepriseDto;
import com.qodexia.smartbox.repositories.EntrepriseRepository;
import com.qodexia.smartbox.repositories.UserRepository;
import com.qodexia.smartbox.services.api.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private EntrepriseMapper entrepriseMapper;

    @Override
    public EntrepriseDto createEntreprise(EntrepriseDto entrepriseDto) {
        Entreprise entrepriseToSave = entrepriseMapper.entrepriseDtoToEntreprise(entrepriseDto);
        entrepriseToSave.setCodeInterne(UUID.randomUUID().toString());
        User manager = userRepository.findById( entrepriseToSave.getUsers().stream().findFirst().orElseThrow(()
                -> new BadRequestException("vous devez affecter l'entreprise à un manager")).getId()).orElseThrow(()
                -> new BadRequestException("vous devez affecter l'entreprise à un manager"));

        if (manager.getId() == null) {
            throw new BadRequestException("Le manager doit être déja sauvegardé dans la base de données");
        }
        if (manager.getRoles().stream().noneMatch(roleUser -> roleUser.getNom().equals(Roles.ROLE_MANAGER.name()))) {
            throw new BadRequestException("Seul un manager peut créer une entreprise");
        }
        Set<User> users = new HashSet<>();
        users.add(userRepository.findById(manager.getId()).orElseThrow(() -> new RessourceNotFoundException("Utilisateur n'existe pas")));
        entrepriseToSave.setUsers(users);
        return entrepriseMapper.entrepriseToEntrepriseDto(entrepriseRepository.save(entrepriseToSave));
    }

    @Override
    public EntrepriseDto updateEntreprise(EntrepriseDto entrepriseDto) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseDto.getId()).orElseThrow(() -> new RessourceNotFoundException("Entreprise n'existe pas"));
        entreprise.setCode(entrepriseDto.getCode());
        entreprise.setVat(entrepriseDto.getVat());
        entreprise.setRaisonSocial(entrepriseDto.getRaisonSocial());
        entreprise.setShareCapital(entrepriseDto.getShareCapital());
        return entrepriseMapper.entrepriseToEntrepriseDto(entrepriseRepository.save(entreprise));
    }

    @Override
    @Transactional(readOnly = true)
    public EntrepriseDto getEntrepriseById(Long id) {
        return entrepriseMapper.entrepriseToEntrepriseDto(entrepriseRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Entreprise n'existe pas")));
    }

    @Override
    @Transactional(readOnly = true)
    public EntrepriseDto getEntrepriseByUserId(Long id) {
        return entrepriseMapper.entrepriseToEntrepriseDto(entrepriseRepository.findOneByUserId(id).orElseThrow(() -> new RessourceNotFoundException("Entreprise n'existe pas")));
    }

    @Override
    public void deleteEntrepriseById(Long id) {
        entrepriseRepository.delete(entrepriseRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Entreprise n'existe pas")));
    }
}

package com.example.assignment.service;

import com.example.assignment.dtos.contactRequestDto;
import com.example.assignment.dtos.contactResponseDto;
import com.example.assignment.model.LinkPrecedence;
import com.example.assignment.model.contacts;
import com.example.assignment.repo.idRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class idService {

    private idRepo irepo;

    public contactResponseDto processContact(contactRequestDto request) {
        List<contacts> matches = irepo.findByEmailOrPhoneNumber(
                request.email(), request.phoneNumber()
        );

        if (matches.isEmpty()) {
            contacts newContact = new contacts();
            newContact.setEmail(request.email());
            newContact.setPhoneNumber(request.phoneNumber());
            newContact.setLinkPrecedence(LinkPrecedence.PRIMARY);
            irepo.save(newContact);

            return new contactResponseDto(
                    newContact.getId(),
                    List.of(request.email()),
                    List.of(request.phoneNumber()),
                    List.of()
            );
        }

        contacts primary = matches.stream()
                .filter(c -> c.getLinkPrecedence() == LinkPrecedence.PRIMARY)
                .min(Comparator.comparing(contacts::getCreatedAt))
                .orElse(matches.get(0));

        boolean emailExists = matches.stream().anyMatch(c -> request.email() != null && request.email().equals(c.getEmail()));
        boolean phoneExists = matches.stream().anyMatch(c -> request.phoneNumber() != null && request.phoneNumber().equals(c.getPhoneNumber()));

        if (!emailExists || !phoneExists) {
            contacts secondary = new contacts();
            secondary.setEmail(request.email());
            secondary.setPhoneNumber(request.phoneNumber());
            secondary.setLinkPrecedence(LinkPrecedence.SECONDARY);
            secondary.setLinkedId(primary.getId());
            irepo.save(secondary);
            matches.add(secondary);
        }

        Set<String> emails = matches.stream()
                .map(contacts::getEmail)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        Set<String> phoneNumbers = matches.stream()
                .map(contacts::getPhoneNumber)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        List<Integer> secondaryIds = matches.stream()
                .filter(c -> !c.getId().equals(primary.getId()))
                .map(contacts::getId)
                .toList();

        return new contactResponseDto(
                primary.getId(),
                new ArrayList<>(emails),
                new ArrayList<>(phoneNumbers),
                secondaryIds
        );
    }
}

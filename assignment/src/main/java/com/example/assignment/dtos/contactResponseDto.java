package com.example.assignment.dtos;

import java.util.List;

public record contactResponseDto(
        Integer Id,
        List<String> emails,
        List<String> phoneNumbers,
        List<Integer> secondaryContactIds
) {
}

package com.example.assignment.dtos;

import java.util.List;

public record contactResponseDto(
        Long primaryContatctId,
        List<String> emails,
        List<String> phoneNumbers,
        List<Long> secondaryContactIds
) {
}

package biblioteca_dio_lab.dio.dto;

import java.time.LocalDateTime;

public record LivroDTO(Long id, String nome, String autor, LocalDateTime anoPublicacao) {
}

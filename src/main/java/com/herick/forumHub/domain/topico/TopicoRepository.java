package com.herick.forumHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoModel, Long> {
    Page<TopicoModel> findAllTopicosByDataCriacao(Pageable paginacao);
}

package com.modepsa.modepsa_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modepsa.modepsa_api.models.Cliente;
import com.modepsa.modepsa_api.models.TipoDocumento;

public interface ClienteRepository extends  JpaRepository<Cliente, Long>{
    boolean existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);

    boolean existsByTipoDocumentoAndNumeroDocumentoAndIdNot(
            TipoDocumento tipoDocumento,
            String numeroDocumento,
            Long id
    );
}

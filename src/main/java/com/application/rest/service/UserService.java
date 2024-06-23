package com.application.rest.service;

import com.application.rest.dto.FindUserRequestDTO;
import com.application.rest.dto.UserDTO;
import com.application.rest.model.User;
import com.application.rest.util.UserUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public Optional<UserDTO> findUserByDNIAndDocumentType(FindUserRequestDTO findUserRequestDTO){
        User user = UserUtils.getUser();

        logger.debug("Looking for user with document type: {} and document number: {}",
                findUserRequestDTO.getTipoDocumento(),
                findUserRequestDTO.getNumeroDocumento());

        if( user.getNumeroDocumento().equals(findUserRequestDTO.getNumeroDocumento()) &&
        user.getTipoDocumento().toString().equals(findUserRequestDTO.getTipoDocumento())){

            logger.info("User found: {}", user.getPrimerNombre());

            return Optional.of(UserDTO.builder()
                            .primerNombre(user.getPrimerNombre())
                            .segundoNombre(user.getSegundoNombre())
                            .primerApellido(user.getPrimerApellido())
                            .segundoApellido(user.getSegundoApellido())
                            .telefono(user.getTelefono())
                            .direccion(user.getDireccion())
                            .ciudadResidencia(user.getCiudadResidencia())
                            .build()
            );
        }

        logger.warn("User not found with document type: {} and document number: {}", findUserRequestDTO.getTipoDocumento(), findUserRequestDTO.getNumeroDocumento());
        return Optional.empty();
    }
}

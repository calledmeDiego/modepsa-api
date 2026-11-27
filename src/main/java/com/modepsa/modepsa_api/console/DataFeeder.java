package com.modepsa.modepsa_api.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.modepsa.modepsa_api.models.Cliente;
import com.modepsa.modepsa_api.models.Estado;
import com.modepsa.modepsa_api.models.Rol;
import com.modepsa.modepsa_api.models.TipoDocumento;
import com.modepsa.modepsa_api.models.Usuario;
import com.modepsa.modepsa_api.repository.ClienteRepository;
import com.modepsa.modepsa_api.repository.UsuarioRepository;

@Component
public class DataFeeder implements CommandLineRunner {
    private final ClienteRepository clienteRepository;

    public DataFeeder(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("###### Inicia la inserción de datos");
        // usuarioRepository.save(new Usuario(null, "Felipe Gabriel", "Hernandez Soto", 50, "hs9090@gmail.com",
        //         "989655124", "20056566335", Estado.ACTIVO, Rol.ADMINISTRADOR, "pepe1010"));
        // usuarioRepository.save(new Usuario(null, "Camila Andrea", "Quispe Mendoza", 28, "cquispe.m@gmail.com",
        //         "945123789", "74859612", Estado.ACTIVO, Rol.ALMACENERO, "camila2026"));
        // usuarioRepository.save(new Usuario(null, "Diego Alejandro", "Rojas Paredes", 34, "drojas.dev@gmail.com",
        //         "912456870", "45128963", Estado.ACTIVO, Rol.ALMACENERO, "diego_pass99"));
        // usuarioRepository.save(new Usuario(null, "Valeria Sofia", "Huaman Flores", 23, "vhuaman.f@gmail.com",
        //         "976321540", "71234568", Estado.INACTIVO, Rol.VENDEDOR, "valeria123"));
        // usuarioRepository.save(new Usuario(null, "Jorge Luis", "Castillo Vargas", 42, "jcastillo.admin@gmail.com",
        //         "963852741", "20457812369", Estado.ACTIVO, Rol.ALMACENERO, "jorgeAdmin77"));
        // usuarioRepository.save(new Usuario(null, "Lucia Fernanda", "Salazar Chavez", 31, "lsalazar.c@gmail.com",
        //         "951753486", "48965231", Estado.ACTIVO, Rol.VENDEDOR, "lucia_2026"));
//         clienteRepository.save(new Cliente(
//         TipoDocumento.DNI,
//         "45891236",
//         "Carlos Alberto",
//         "Quispe Mamani",
//         null,
//         "cquispe.m@gmail.com",
//         "987654321",
//         "Av. Los Incas 420, Huamanga, Ayacucho",
//         Estado.ACTIVO
// ));

// clienteRepository.save(new Cliente(
//         TipoDocumento.RUC,
//         "20608412951",
//         null,
//         null,
//         "Inversiones Andinas S.A.C.",
//         "compras@inversionesandinas.pe",
//         "965432187",
//         "Jr. 28 de Julio 158, Ayacucho",
//         Estado.ACTIVO
// ));

// clienteRepository.save(new Cliente(
//         TipoDocumento.CE,
//         "004829173",
//         "Lucia Fernanda",
//         "Rojas Mendoza",
//         null,
//         "lucia.rojas@hotmail.com",
//         "954123678",
//         "Urb. Mariscal Caceres Mz. D Lt. 12, Ayacucho",
//         Estado.INACTIVO
// ));
        System.out.println("###### Finaliza la insercion de datos");
    }

}

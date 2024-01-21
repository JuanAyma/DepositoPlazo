package com.bbva.costumermicroservice.controller;

import com.bbva.costumermicroservice.entity.CustomerEntity;
import com.bbva.costumermicroservice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/cliente")

public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarClientes(){
        List<?> clientes= customerService.findAll();
        if (!clientes.isEmpty()){

            return ResponseEntity.ok(clientes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron clientes");
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarCliente(@RequestParam Long id){
        CustomerEntity customerEntity = customerService.findById(id);
        if (customerEntity !=null){
            return ResponseEntity.ok(customerEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarCliente(@RequestBody CustomerEntity customerEntity){
        customerService.save(customerEntity);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizarCliente(@PathVariable Long id, @RequestBody CustomerEntity clienteActualizado) {
        // Puedes implementar la lógica para obtener el cliente existente por ID y actualizar sus campos
        CustomerEntity clienteExistente = customerService.findById(id);

        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            // Actualiza otros campos según sea necesario

            customerService.save(clienteExistente);
        } else {
            // Manejar la situación en la que el cliente no existe
            //throw new ClienteNotFoundException("Cliente no encontrado con ID: " + id);
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");

        }
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCliente(@PathVariable Long id){
        customerService.deleteById(id);
    }

}

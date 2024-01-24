package com.bbva.costumermicroservice.controller;

import com.bbva.costumermicroservice.dto.CustomerDTO;
import com.bbva.costumermicroservice.model.Account;
import com.bbva.costumermicroservice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/buscar/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron clientes");
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado");
    }

    @PutMapping("/actualizar/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO updatedCustomer) {
        customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente actualizado");
    }

    @DeleteMapping("/eliminar/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminado");
    }

    @GetMapping("/accounts/{customerId}")
    public ResponseEntity<?> getAccountsByCustomerId(@PathVariable Long customerId) {
        List<Account> accounts = customerService.getAccountsByCustomerId(customerId);
        if (!accounts.isEmpty()) {
            return ResponseEntity.ok(accounts);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cuentas");
    }
////////////////////////////////////////////////////////////////////////
   /* @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerDTO);
    }

    */

}

    /*@GetMapping("/listar")
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
        Customer customer = customerService.findById(id);
        if (customer !=null){
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarCliente(@RequestBody Customer customer){
        customerService.save(customer);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizarCliente(@PathVariable Long id, @RequestBody Customer clienteActualizado) {
        // Puedes implementar la lógica para obtener el cliente existente por ID y actualizar sus campos
        Customer clienteExistente = customerService.findById(id);

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

    //////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/by-customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarCuentasPorClienteId(@PathVariable Long customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
        }
        List<Account> accounts = customerService.findAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }*/
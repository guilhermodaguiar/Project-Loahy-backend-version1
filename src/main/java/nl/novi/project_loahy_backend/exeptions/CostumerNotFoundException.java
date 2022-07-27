package nl.novi.project_loahy_backend.exeptions;

 public class CostumerNotFoundException extends RuntimeException {
     private static final long serialVersionUID = 1L;


     public CostumerNotFoundException(Long userNumber) {

         super(String.format("Costumer '%s' does not exists", userNumber));
     }

 }
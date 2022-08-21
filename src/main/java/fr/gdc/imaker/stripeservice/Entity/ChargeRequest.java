package fr.gdc.imaker.stripeservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargeRequest {
           public enum Currency {
                              EUR, USD;
                  }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
}



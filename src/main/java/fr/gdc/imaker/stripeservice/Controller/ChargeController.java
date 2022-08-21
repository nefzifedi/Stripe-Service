package fr.gdc.imaker.stripeservice.Controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import fr.gdc.imaker.stripeservice.Entity.ChargeRequest;
import fr.gdc.imaker.stripeservice.Exception.APIException;
import fr.gdc.imaker.stripeservice.Service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.AuthenticationException;

@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException, APIException, AuthenticationException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }



}

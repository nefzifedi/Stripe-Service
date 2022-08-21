package fr.gdc.imaker.stripeservice.Controller;


import fr.gdc.imaker.stripeservice.Entity.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model , @RequestParam(required = true) String systemUserId , @RequestParam(required = true) Integer amount) {
        model.addAttribute("amount", amount * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        model.addAttribute("systemUserId", systemUserId);
        return "checkout";

}






}

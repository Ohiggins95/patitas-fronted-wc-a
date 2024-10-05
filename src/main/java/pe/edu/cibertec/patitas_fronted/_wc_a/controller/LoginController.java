package pe.edu.cibertec.patitas_fronted._wc_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.cibertec.patitas_fronted._wc_a.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_fronted._wc_a.dto.LoginResponseDTO;
import pe.edu.cibertec.patitas_fronted._wc_a.viewmodel.LoginModel;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    WebClient webClientAutenticacion;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        LoginModel loginModel = new LoginModel("00", "", "");
        model.addAttribute("loginModel", loginModel);
        return "inicio";
    }


    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("tipoDocumento") String tipoDocumento,
                             @RequestParam("numeroDocumento") String numeroDocumento,
                             @RequestParam("password") String password,
                             Model model) {

        // Validar campos de entrada
        if (tipoDocumento == null || tipoDocumento.trim().isEmpty() ||
                numeroDocumento == null || numeroDocumento.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {

            LoginModel loginModel = new LoginModel("01", "Error: Debe completar correctamente sus credenciales", "");
            model.addAttribute("loginModel", loginModel);
            return "inicio";

        }

        // Hacer la solicitud al backend

        try {

            LoginRequestDTO loginRequestDTO = new LoginRequestDTO(tipoDocumento, numeroDocumento, password);
            LoginResponseDTO loginResponseDTO = webClientAutenticacion.postForObject("/login", loginRequestDTO, LoginResponseDTO.class);

            if (loginResponseDTO.codigo().equals("00")){

                LoginModel loginModel = new LoginModel("00", "", loginResponseDTO.nombreUsuario());
                model.addAttribute("loginModel", loginModel);
                return "principal";

            } else {

                LoginModel loginModel = new LoginModel("02", "Error: Autenticación fallida", "");
                model.addAttribute("loginModel", loginModel);
                return "inicio";

            }

        } catch (Exception e) {
            LoginModel loginModel = new LoginModel("99", "Error: Ocurrió un problema en la autenticación", "");
            model.addAttribute("loginModel", loginModel);
            System.out.println(e.getMessage());
            return "inicio";

        }


        //String url = "http://localhost:8081/autenticacion/login";
        // LoginRequest loginreqDTO = new LoginRequest(tipoDocumento, numeroDocumento, password);
        //LoginModel loginModel= restTemplate.postForObject(url, loginreqDTO,LoginModel.class);

        //validando respuesta del back
        // if(loginModel !=null && "00".equals(loginModel.codigo())){
        //model.addAttribute("loginModel", loginModel);
        // return "principal";
        //}else {
        //  model.addAttribute("loginModel", new LoginModel("01","usuario incorrecto",""));


    }}


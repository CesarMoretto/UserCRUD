package com.exemplo.cadastro.controller;

import com.exemplo.cadastro.model.Usuario;
import com.exemplo.cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/usuarios/html")
    public String salvarUsuarioHtml(@ModelAttribute Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    @ResponseBody
    public Optional<Usuario> buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @PostMapping("/usuarios")
    @ResponseBody
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseBody
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioService.buscarUsuario(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "editar-usuario";
        }
        return "redirect:/";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuario.setId(id);
        usuarioService.salvarUsuario(usuario);
        return "redirect:/";
    }

    @PostMapping("/usuarios/deletar/{id}")
    public String deletarUsuarioHtml(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/";
    }
}

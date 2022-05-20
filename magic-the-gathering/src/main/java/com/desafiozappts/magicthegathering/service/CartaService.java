package com.desafiozappts.magicthegathering.service;

import com.desafiozappts.magicthegathering.entity.Carta;
import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CartaService {

    private CartaRepository cartaRepository;

    @Autowired
    public CartaService(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }


    public List<Carta> listarCartasOrdemPreco (){

        List <Carta> cartasOrdenadas = cartaRepository.findAll();

        cartasOrdenadas.sort(Comparator.comparing(Carta::getValor));

         return cartasOrdenadas;

    }

    public List<Carta> listarCartasOrdemAlfabetica (){

        List <Carta> cartasOrdenadas = cartaRepository.findAll();

        cartasOrdenadas.sort(Comparator.comparing(Carta::getNome));

        return cartasOrdenadas;

    }

    public Carta inserir (Carta carta){

        return cartaRepository.save(carta);
    }

    public Carta atualizar (Integer id, Carta carta) throws CartaNaoCadastradaException {

        cartaRepository.findById(id).orElseThrow(() -> new CartaNaoCadastradaException(id));
        carta.setId(id);

        return cartaRepository.save(carta);
    }

    public void excluirCarta (Integer id) throws CartaNaoCadastradaException {

        verficarExistencia(id);
        cartaRepository.deleteById(id);
    }

    private Carta verficarExistencia (Integer id) throws CartaNaoCadastradaException {

        return cartaRepository.findById(id)
                .orElseThrow(()-> new CartaNaoCadastradaException(id));
    }


}

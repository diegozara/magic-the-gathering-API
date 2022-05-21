package com.desafiozappts.magicthegathering.service;

import com.desafiozappts.magicthegathering.entity.Carta;
import com.desafiozappts.magicthegathering.entity.Jogador;
import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.exception.JogadorNaoCadastradoException;
import com.desafiozappts.magicthegathering.exception.SolicitacaoNegada;
import com.desafiozappts.magicthegathering.repository.CartaRepository;
import com.desafiozappts.magicthegathering.repository.JogadorRepository;
import com.desafiozappts.magicthegathering.repository.ListaCartas;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CartaService {

    private CartaRepository cartaRepository;

    private JogadorRepository jogadorRepository;

    @Autowired
    public CartaService(CartaRepository cartaRepository, JogadorRepository jogadorRepository) {

        this.cartaRepository = cartaRepository;
        this.jogadorRepository = jogadorRepository;
    }


    public List<ListaCartas> listarTodasCartas (){

            return cartaRepository.listarCartas();
        //    return cartaRepository.findAll();
    }

    public List<ListaCartas> listarCartasOrdemPreco () throws CartaNaoCadastradaException {

        List<ListaCartas> cartasOrdenadas = cartaRepository.listarCartas();

        if (cartasOrdenadas.isEmpty()){

            throw new CartaNaoCadastradaException();

        } else {
            cartasOrdenadas.sort(Comparator.comparing(ListaCartas::getvalor));
            return cartasOrdenadas;
        }
    }

    public List<ListaCartas> listarCartasOrdemAlfabetica () throws CartaNaoCadastradaException {

        List<ListaCartas> cartasOrdenadas = cartaRepository.listarCartas();

        if (cartasOrdenadas.isEmpty()){

            throw new CartaNaoCadastradaException();

        } else {
            cartasOrdenadas.sort(Comparator.comparing(ListaCartas::getnome));
            return cartasOrdenadas;
        }

      }

    public Carta inserir (Carta carta) throws JogadorNaoCadastradoException {

        setCartaJogador(carta);
        return cartaRepository.save(carta);
    }

    public Carta atualizar (String cpf,Integer id, Carta carta) throws CartaNaoCadastradaException, JogadorNaoCadastradoException, SolicitacaoNegada {

        cartaRepository.findById(id).orElseThrow(() -> new CartaNaoCadastradaException(id));

        carta.setId(id);

        setCartaJogador(carta);

        verficaCPF(carta,cpf);

        return cartaRepository.save(carta);
    }

    public void excluirCarta (String cpf, Integer id) throws CartaNaoCadastradaException, SolicitacaoNegada {

        Carta carta = verficarExistencia(id);

        if (carta.getJogador().getCpf().equals(cpf)){
        cartaRepository.deleteById(id);}

        else throw new SolicitacaoNegada();
    }

    private Carta verficarExistencia (Integer id) throws CartaNaoCadastradaException {

        return cartaRepository.findById(id)
                .orElseThrow(()-> new CartaNaoCadastradaException(id));
    }

    private Carta setCartaJogador (Carta carta) throws JogadorNaoCadastradoException {

        Optional<Jogador> jogador = jogadorRepository.findById(carta.getJogador().getCpf());

        if (jogador.isEmpty()){
            throw new JogadorNaoCadastradoException();

        }  else {
            carta.setJogador(jogador.get());
            return carta;
            }
    }
    @ApiOperation(value = "Método utilizado para restringir as alterações nas cartas, validação através do CPF do jogador")
    private Carta verficaCPF (Carta carta, String cpf) throws SolicitacaoNegada {


            if (carta.getJogador().getCpf().equals(cpf)){
                return carta;
            }
            else { throw new SolicitacaoNegada(); }
        }

}




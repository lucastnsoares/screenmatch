package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

   @GetMapping
    public List<SerieDTO> obterSeries(){
        return servico.obterTodasAsSeries();
   }

   @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
       return servico.obterTop5Series();
   }

   @GetMapping("/lancamentos")
   public List<SerieDTO> obterLancamentos() {
       return servico.obterLancmentos();
   }

   @GetMapping("/{id}")
   public SerieDTO obterDadosSerie(@PathVariable Long id) {
       return servico.obterDadosSerie(id);
   }

   @GetMapping("/{id}/temporadas/todas")
   public List<EpisodioDTO> obterTodosEpisodios (@PathVariable Long id) {
       return servico.obterTodosEpisodios(id);

   }

   @GetMapping("/{idSerie}/temporadas/{numeroTemporada}")
   public List<EpisodioDTO> obterEpisodiosPorTemporada(@PathVariable Long idSerie, @PathVariable Long numeroTemporada) {
       return servico.obterEpisodiosPorTemporada(idSerie, numeroTemporada);
   }

   @GetMapping("/categoria/{genero}")
   public List<SerieDTO> obterSeriesPorGenero (@PathVariable String genero) {
       return servico.obterSeriesPorGenero(genero);
   }

}

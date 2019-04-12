package br.com.deem.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.RANKING_PATH)
public class RankingService extends GenericService<RankingEntity,Long>{
	
	@Autowired
	private RankingRepository rankingRepository;


	
}

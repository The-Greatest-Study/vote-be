package tgs.vote.adapter.out.external;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import tgs.vote.adapter.model.persistence.vote.VoteEntity;
import tgs.vote.adapter.out.config.SupabaseFeignClientConfig;

@FeignClient(
        name = "supabase",
        url = "https://utiebnnujtpycwrzeipk.supabase.co",
        configuration = SupabaseFeignClientConfig.class)
public interface SupabaseFeignClient {
    @GetMapping(value = "/rest/v1/tb_vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<VoteEntity> getVoteList();
}

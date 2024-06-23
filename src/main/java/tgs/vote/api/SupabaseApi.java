package tgs.vote.api;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import tgs.vote.api.config.SupabaseApiConfig;
import tgs.vote.vote.entity.VoteEntity;

@FeignClient(
        name = "supabase",
        url = "https://utiebnnujtpycwrzeipk.supabase.co",
        configuration = SupabaseApiConfig.class)
public interface SupabaseApi {
    @GetMapping(value = "/rest/v1/tb_vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<VoteEntity> getVoteList();
}

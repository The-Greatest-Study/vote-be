<<<<<<<< HEAD:src/main/java/tgs/vote/adapter/out/impl/SupabaseFeignClient.java
package tgs.vote.adapter.out.impl;
========
package tgs.vote.adapter.out.client;
>>>>>>>> f8b5d91b83a8926a6861907326a3be25f93a09b4:src/main/java/tgs/vote/adapter/out/client/SupabaseFeignClient.java

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import tgs.vote.adapter.out.config.SupabaseFeignClientConfig;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;

@FeignClient(
        name = "supabase",
        url = "https://utiebnnujtpycwrzeipk.supabase.co",
        configuration = SupabaseFeignClientConfig.class)
public interface SupabaseFeignClient {
    @GetMapping(value = "/rest/v1/tb_vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<VoteEntity> getVoteList();
}

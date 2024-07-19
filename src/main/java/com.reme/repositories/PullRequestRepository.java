package com.reme.repositories;

import com.reme.entity.PullRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullRequestRepository extends CrudRepository<PullRequest, String>   {
}

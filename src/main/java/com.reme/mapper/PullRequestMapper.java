package com.reme.mapper;

import com.reme.entity.PullRequest;
import com.reme.model.PullRequestDTO;

public class PullRequestMapper {

    public static PullRequestDTO toDto(PullRequest entity) {
        PullRequestDTO dto = new PullRequestDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setLabel_names(entity.getLabelNames());
        dto.setUser_type(entity.getUserType());
        dto.setUrl(entity.getUrl());
        dto.setCreated_at(entity.getCreatedAt());
        dto.setUpdated_at(entity.getUpdatedAt());
        dto.setClosed_at(entity.getClosedAt());
        dto.setMerged_at(entity.getMergedAt());
        dto.setState(entity.getState());
        dto.setBody(entity.getBody());
        dto.setRepo(entity.getRepo());
        return dto;
    }

    public static PullRequest toEntity(PullRequestDTO dto) {
        PullRequest entity = new PullRequest();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setLabelNames(dto.getLabel_names());
        entity.setUserType(dto.getUser_type());
        entity.setUrl(dto.getUrl());
        entity.setCreatedAt(dto.getCreated_at());
        entity.setUpdatedAt(dto.getUpdated_at());
        entity.setClosedAt(dto.getClosed_at());
        entity.setMergedAt(dto.getMerged_at());
        entity.setState(dto.getState());
        entity.setBody(dto.getBody());
        entity.setRepo(dto.getRepo());
        return entity;
    }
}

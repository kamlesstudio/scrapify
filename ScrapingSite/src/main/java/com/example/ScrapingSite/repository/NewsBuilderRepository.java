package com.example.ScrapingSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ScrapingSite.model.NewsBuilder;
@Repository
public interface NewsBuilderRepository extends JpaRepository<NewsBuilder, Integer> {
}
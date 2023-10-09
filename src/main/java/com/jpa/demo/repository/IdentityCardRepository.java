package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.IdentityCard;
@Repository
public interface IdentityCardRepository extends JpaRepository <IdentityCard,Long>{

}

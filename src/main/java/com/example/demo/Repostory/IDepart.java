package com.example.demo.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Departs;
import com.example.demo.Entity.Collaborator; 

@Repository
public interface IDepart extends JpaRepository<Departs, Integer>{
	   List<Departs> findByCollaborator(Collaborator collaborateur);
      
	
}

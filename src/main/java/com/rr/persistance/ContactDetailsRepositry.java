package com.rr.persistance;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContactDetailsRepositry  extends JpaRepository<ContactDetailsEntity,Serializable>{
    @Modifying
    @Transactional
    @Query("update ContactDetailsEntity set contact_Sw=:sw where contactId= :cid")
	public void update(String sw,Integer cid);
}

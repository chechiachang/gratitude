package com.ccc.system;

import java.util.Collection;

import com.ccc.system.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{
    Collection<Bookmark> findByAccountUsername(String username);
}

package net.thanhdevjava.personal_blogging_platform.repository;

import net.thanhdevjava.personal_blogging_platform.enity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}

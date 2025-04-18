package net.thanhdevjava.personal_blogging_platform.controller;

import lombok.AllArgsConstructor;
import net.thanhdevjava.personal_blogging_platform.dto.BlogDTO;
import net.thanhdevjava.personal_blogging_platform.dto.BlogRequest;
import net.thanhdevjava.personal_blogging_platform.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blog")
@CrossOrigin
public class BlogController {

    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogRequest blogRequest) {
        return new ResponseEntity<>(blogService.createBlog(blogRequest),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlogById(id);
        return ResponseEntity.ok("Delete blog with id: " + id);
    }
}

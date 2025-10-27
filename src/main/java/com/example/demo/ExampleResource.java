package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/example")
public class ExampleResource {

    /**
     * Simple GET endpoint that returns a greeting message
     * GET /api/example/hello
     */
    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    /**
     * GET endpoint with path parameter
     * GET /api/example/user/{id}
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = new User(id, "John Doe", "john.doe@example.com");
        return ResponseEntity.ok(user);
    }

    /**
     * GET endpoint with query parameter
     * GET /api/example/search?name=John
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        SearchResult result = new SearchResult(name, "Searching for: " + name);
        return ResponseEntity.ok(result);
    }

    // Response classes
    static class User {
        private Long id;
        private String name;
        private String email;

        public User(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    static class SearchResult {
        private String query;
        private String results;

        public SearchResult(String query, String results) {
            this.query = query;
            this.results = results;
        }

        public String getQuery() { return query; }
        public void setQuery(String query) { this.query = query; }
        public String getResults() { return results; }
        public void setResults(String results) { this.results = results; }
    }
}
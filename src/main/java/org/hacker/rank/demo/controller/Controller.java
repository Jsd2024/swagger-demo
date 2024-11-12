package org.hacker.rank.demo.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/files")
public class Controller {
    @Operation(summary = "Upload a file", description = "Upload a file to the server",
            requestBody = @RequestBody(content = @Content(mediaType = "multipart/form-data",
                    schema = @Schema(type = "string", format = "binary"))))
    @ApiResponse(responseCode = "200", description = "File uploaded successfully")
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        // Process the file here
        String fileName = file.getOriginalFilename();
        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }
}



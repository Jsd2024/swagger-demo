package org.swagger.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/files")
public class Controller {
    @Operation(summary = "Upload a file", description = "Upload a file to the server",
            requestBody = @RequestBody(content = @Content(mediaType = "multipart/form-data")))
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

    @Operation(summary = "Upload a Text", description = "Upload a Text to the server",
            requestBody = @RequestBody(content = @Content(mediaType = "application/json")))
    @ApiResponse(responseCode = "200", description = "Text uploaded successfully")
    @PostMapping(value = "/text", consumes = "application/json")
    public ResponseEntity<String> testString(@RequestParam("text") String str) {
        String textDesc = null;
        if (str.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Text is empty");
        }
        else{
            if(str.describeConstable().isPresent()) {
                textDesc =  str.describeConstable().get();
            }
        }
        return ResponseEntity.ok("Text uploaded successfully: " + textDesc);
    }
}



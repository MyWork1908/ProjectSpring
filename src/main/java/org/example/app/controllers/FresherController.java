package org.example.app.controllers;

import org.example.app.models.dto.FresherDTO;
import org.example.app.models.dto.mapper.FresherMapper;
import org.example.app.models.entity.Fresher;
import org.example.app.models.response.ResponseObject;
import org.example.app.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/fresher")
public class FresherController {
    @Autowired
    FresherService fresherService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all fresher successfully",
                        Collections.singletonList(fresherService.getAllFresher()))
        );
    }
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert fresher successfully",
                        fresherService.addFresher(fresher))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        fresherService.editFresher(fresher))
        );
    }
    @DeleteMapping("/delete/{fresherId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String fresherId) {
        fresherService.deleteFresher(fresherId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Delete fresher successfully","")
        );
    }
    @GetMapping("/transcript")
    public ResponseEntity<ResponseObject> getTranscript(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get transcript successfully",
                        Collections.singletonList(fresherService.getTranscript()))
        );
    }
    @GetMapping("/search/name")
    public ResponseEntity<ResponseObject> searchFresherWithFresherName(@RequestParam String fresherName){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with fresher name successfully",
                        Collections.singletonList(fresherService.searchFresherWithFresherName(fresherName)))
        );
    }
    @GetMapping("/search/mail")
    public ResponseEntity<ResponseObject> searchFresherWithFresherEmail(@RequestParam String fresherEmail){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with fresher mail successfully",
                        fresherService.searchFresherWithFresherEmail(fresherEmail))
        );
    }
    @GetMapping("/search/lp")
    public ResponseEntity<ResponseObject> searchFresherWithLP(@RequestParam String lp){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with language programming successfully",
                        Collections.singletonList(fresherService.searchFresherWithLP(lp)))
        );
    }
}

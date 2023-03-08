package org.example.app.controllers;

import org.example.app.models.dto.CenterDTO;
import org.example.app.models.dto.mapper.CenterMapper;
import org.example.app.models.entity.Center;
import org.example.app.models.response.ResponseObject;
import org.example.app.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService centerService;
    @GetMapping("/all")
    public ResponseEntity<ResponseObject> getAllCenter() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all center successfully",
                        Collections.singletonList(centerService.getAllCenter()))
        );
    }
    @GetMapping(path = "/fresher/{centerCode}")
    public ResponseEntity<ResponseObject> getAllFresherOfCenter(@PathVariable String centerCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Get All fresher of center " + centerCode,
                        Collections.singletonList(centerService.getListFresherOfCenter(centerCode)))
        );
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Insert center successfully",
                        Collections.singletonList(centerService.addCenter(center)))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        centerService.editCenter(center))
        );
    }
    @DeleteMapping("/delete/{centerCode}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String centerCode) {
        centerService.deleteCenter(centerCode);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Delete fresher successfully","")
        );
    }
}

package com.example.testTask.controller;

import com.example.testTask.entity.MembersGroup;
import com.example.testTask.service.Finder;
import com.example.testTask.service.MembersGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memberGroup")
public class MembersGroupController {

    @Autowired
    private MembersGroupService membersGroupService;

    @Autowired
    private Finder.FinderOldMan finderOldMan;

    @PostMapping
    public ResponseEntity addMemberGroup(@RequestBody MembersGroup membersGroup){
        try {
            return ResponseEntity.ok(membersGroupService.createMemberGroup(membersGroup));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping
    public ResponseEntity getMembersGroups() {
        try {
            return ResponseEntity.ok(membersGroupService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/old")
    public ResponseEntity findOldMembers() {
        try {
            return ResponseEntity.ok(finderOldMan.getOldMembers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}

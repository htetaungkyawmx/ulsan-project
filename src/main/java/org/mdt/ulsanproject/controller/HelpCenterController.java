package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.service.HelpCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpCenterController {
    @Autowired
    private HelpCenterService helpCenterService;

}

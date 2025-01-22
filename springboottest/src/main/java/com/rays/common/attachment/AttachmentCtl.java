package com.rays.common.attachment;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;

/**
 * REST API to attach a file in the application.
 * Suraj Sahu
 */
@RestController
@RequestMapping("Attachment")
public class AttachmentCtl extends BaseCtl<AttachmentForm, AttachmentDTO, AttachmentServiceInt> {

    /**
     * Uploads a file. If the ID exists in the database, the document is updated; otherwise, it is added to the database.
     * 
     * @param id the ID of the document (optional)
     * @param file the file to upload
     * @param description the description of the file (optional)
     * @param req the HTTP request
     * @return a map containing the status and metadata of the uploaded file
     */
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam(required = false) Long id, @RequestParam("file") MultipartFile file,
            @RequestParam(required = false) String description, HttpServletRequest req) {

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        AttachmentDTO doc = new AttachmentDTO(file);
        doc.setId(id);
        doc.setDescription(description);
        doc.setPath(req.getServletPath());
        doc.setUserId(userContext.getUserId());

        Long pk = baseService.save(doc, userContext);

        response.put("id", pk);
        response.put("name", doc.getName());
        response.put("type", doc.getType());
        response.put("size", file.getSize());

        return response;
    }

    /**
     * Downloads a document for the given ID.
     * 
     * @param id the ID of the document
     * @param response the HTTP response
     */
    @GetMapping("/download/{id}")
    public @ResponseBody void download(@PathVariable long id, HttpServletResponse response) {

        AttachmentDTO dto = baseService.findById(id, userContext);

        try {
            if (dto != null) {
                response.setContentType(dto.getType());
                OutputStream out = response.getOutputStream();
                out.write(dto.getDoc());
                out.close();
            } else {
                response.getWriter().write("ERROR: File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ORSResponse search(@RequestBody AttachmentForm form) {

        AttachmentSummaryDTO dto = new AttachmentSummaryDTO();
        dto.setId(form.getId());
        dto.setName(form.getName());
        dto.setType(form.getType());
        dto.setTags(form.getTags());
        dto.setUserId(form.getUserId());
        dto.setPath(form.getPath());

        ORSResponse res = new ORSResponse(true);
        res.addData(baseService.search(dto, userContext));

        return res;
    }

    @Override
    public ORSResponse search(@RequestBody AttachmentForm form, int pageNo) {
        pageNo = (pageNo < 0) ? 0 : pageNo;

        AttachmentSummaryDTO dto = new AttachmentSummaryDTO();
        dto.setId(form.getId());
        dto.setName(form.getName());
        dto.setType(form.getType());
        dto.setTags(form.getTags());
        dto.setUserId(form.getUserId());
        dto.setPath(form.getPath());

        ORSResponse res = new ORSResponse(true);
        res.addData(baseService.search(dto, pageNo, 5, userContext));

        return res;
    }
}

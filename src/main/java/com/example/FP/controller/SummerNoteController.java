package com.example.FP.controller;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;



@Controller
public class SummerNoteController {

	@PostMapping(value="/uploadSummernoteImageFile")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		JsonObject jsonObject = new JsonObject();

		String fileRoot = request.getServletContext().getRealPath("/ingredientImages");	//저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot+"/" + savedFileName);
		String url = "";
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			url = ("../../static/ingredientImages/"+savedFileName);
			url = ("../../static/ingredientImages/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (Exception e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		return url;
	}
	
	@PostMapping("/deleteSummernoteImageFile")
	@ResponseBody
	public void deleteSummernoteImageFile(@RequestParam("file") String filename, HttpServletRequest request) {
		String fileRoot = request.getServletContext().getRealPath("/ingredientImages");	//저장될 외부 파일 경로
		File file = new File(fileRoot+"/"+filename);
		FileUtils.deleteQuietly(file);	//저장된 파일 삭제
	}
}

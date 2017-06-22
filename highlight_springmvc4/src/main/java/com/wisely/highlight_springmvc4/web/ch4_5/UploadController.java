package com.wisely.highlight_springmvc4.web.ch4_5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file) {// 1 使用MultipartFile 接收页面 来的 上传文件。

		try {
			FileUtils.writeByteArrayToFile(new File("d:/upload/" + file.getOriginalFilename()), file.getBytes()); 
			// 2 使用FileUtils.writeByteArrayToFile() 快速写文件到硬盘。
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}

	}

}

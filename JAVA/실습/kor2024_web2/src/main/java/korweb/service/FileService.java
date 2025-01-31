package korweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    // * 서버 경로 내 이미지폴더
    // 프로젝트폴더명 -> build -> resources -> main -> static -> img폴더 -> 'copy path' -> absolute path
    // 마지막 경로 뒤에 '\\' 추가
    String uploadPath = "/Users/jimyung/INCHEON_STUDY_DEVELOP/JAVA/실습/kor2024_web2/build/resources/main/static/img/";

    // 1. 업로드 함수/메소드
    public String fileUpload(MultipartFile multipartFile) {
        // 1. 매개변수로 MultipartFile 타입 객체를 받는다. 클라이언트가 보낸 첨부파일이 들어있는 객체
        System.out.println(multipartFile.getOriginalFilename()); // 첨부파일의 파일명을 반환하는 함수
        System.out.println(multipartFile.getName()); // 첨부파일의 속성명을 반환하는 함수
        System.out.println(multipartFile.getSize()); // 첨부파일의 용량을 반환하는 함수 (byte)
        System.out.println(multipartFile.isEmpty()); // 첨부파일의 존재여부를 반환하는 함수

        // 만약에 서로 다른 파일을 동일한 이름으로 업로드 했을 때 파일명 식별 불가능
        // 방안 : 파일명 앞에 UUID 난수 텍스트 조합
        // UUID.randomUUID().toString(); -> 난수로 UUID 규약 텍스트 생성
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        // 2. 업로드 경로와 파일명 조합하기 (업로드경로 + uuid + 파일명)
            // uuid의 구분자는 '-'하이픈을 사용하므로 파일명에 하이픈이 존재하면 안된다.
            // 파일명의 '-'하이픈을 모두 '_'언더바로 변경해야한다.
            // 예) aasd-fsdmfn-el23k4j-2peofs-파일명
        String fileName =  uuid + "-" +  multipartFile.getOriginalFilename().replaceAll("-","_");
        String uploadFile = uploadPath + fileName;

        // 3. 조합된 경로로 file 클래스 객체 만들기
        File file = new File(uploadFile);

        try{// 4. 업로드하기 , transferTo( 지정된 경로)
            multipartFile.transferTo(file);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("파일 업로드 실패");
            // 업로드 실패하면 null
            return null;
        } // try-catch end

        // 업로드 성공하면 성공한 파일명 반환
        return fileName;
    }// fileUpload end

    // 2. 다운로드 함수/메소드
}

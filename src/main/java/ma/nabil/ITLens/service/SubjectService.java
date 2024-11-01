package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubjectById(Integer id);
    List<SubjectDTO> getRootSubjects(Integer surveyId);
    List<SubjectDTO> getChildSubjects(Integer parentId);
    SubjectDTO updateSubject(Integer id, SubjectDTO subjectDTO);
    void deleteSubject(Integer id);
    Subject getSubjectEntity(Integer id);
    SubjectDTO addChildSubject(Integer parentId, SubjectDTO childDTO);
}
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
    SubjectDTO updateSubject(Integer id, SubjectDTO subjectDTO);
    void deleteSubject(Integer id);
    Subject getSubjectEntity(Integer id);
}
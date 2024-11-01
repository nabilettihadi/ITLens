package ma.nabil.ITLens.service;

import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService extends GenericService<SubjectDTO, Integer> {
    List<SubjectDTO> getRootSubjects(Integer surveyId);
    List<SubjectDTO> getChildSubjects(Integer parentId);
    Subject getSubjectEntity(Integer id);
    SubjectDTO addChildSubject(Integer parentId, SubjectDTO childDTO);
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dao.ConceptDao;
import com.sg.creativity.suite.dao.IdeaDao;
import com.sg.creativity.suite.dao.Idea_ConceptDao;
import com.sg.creativity.suite.dao.Idea_ProblemDao;
import com.sg.creativity.suite.dao.Idea_ValueDao;
import com.sg.creativity.suite.dao.ProblemDao;
import com.sg.creativity.suite.dao.SessionDao;
import com.sg.creativity.suite.dao.Session_ProblemDao;
import com.sg.creativity.suite.dao.ValueDao;
import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Concept;
import com.sg.creativity.suite.dto.Idea_Problem;
import com.sg.creativity.suite.dto.Idea_Value;
import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Session_Problem;
import com.sg.creativity.suite.dto.Value;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.inject.Inject;

/**
 *
 * @author matt
 */
public class DaoTestHelper {
    
    @Inject IdeaDao ideaDao;
    @Inject ConceptDao conceptDao;
    @Inject ValueDao valueDao;
    @Inject ProblemDao problemDao;
    @Inject SessionDao sessionDao;
    @Inject Idea_ConceptDao icDao;
    @Inject Idea_ProblemDao ipDao;
    @Inject Idea_ValueDao ivDao;
    @Inject Session_ProblemDao spDao;
    
    Idea insertTwoIdea_ConceptsSharingSameIdea(){
        Idea idea = makeIdeaAndSetFields();
        Concept concept1 = makeConceptAndSetFields();
        Concept concept2 = makeConceptAndSetFields();
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept1);
        conceptDao.insertConcept(concept2);
        
        Idea_Concept ic1 = new Idea_Concept();
        Idea_Concept ic2 = new Idea_Concept();
        
        ic1.setIdea(idea);
        ic1.setConcept(concept1);
        
        ic2.setIdea(idea);
        ic2.setConcept(concept2);
        
        icDao.insertIdea_Concept(ic1);
        icDao.insertIdea_Concept(ic2);
        return idea;
    }
    Concept insertTwoIdea_ConceptsSharingSameConcept(){
        Concept concept = makeConceptAndSetFields();
        Idea idea1 = makeIdeaAndSetFields();
        Idea idea2 = makeIdeaAndSetFields();
        
        conceptDao.insertConcept(concept);
        ideaDao.insertIdea(idea1);
        ideaDao.insertIdea(idea2);
        
        Idea_Concept ic1 = new Idea_Concept();
        Idea_Concept ic2 = new Idea_Concept();
        
        ic1.setConcept(concept);
        ic1.setIdea(idea1);
        
        ic2.setConcept(concept);
        ic2.setIdea(idea2);
        
        icDao.insertIdea_Concept(ic1);
        icDao.insertIdea_Concept(ic2);
        return concept;
    }
    
    Idea insertTwoIdea_ProblemsSharingSameIdea(){
        Idea idea = insertAnIdea();
        Problem problem1 = insertAProblem();
        Problem problem2 = insertAProblem();
        
        Idea_Problem ip1 = new Idea_Problem();
        Idea_Problem ip2 = new Idea_Problem();
        
        ip1.setIdea(idea);
        ip1.setProblem(problem1);
        
        ip2.setIdea(idea);
        ip2.setProblem(problem2);
        
        ipDao.insertIdea_Problem(ip1);
        ipDao.insertIdea_Problem(ip2);
        return idea;
    }
    Problem insertTwoIdea_ProblemsSharingSameProblem(){
        Problem problem = makeProblemAndSetFields();
        Idea idea1 = makeIdeaAndSetFields();
        Idea idea2 = makeIdeaAndSetFields();
        
        problemDao.insertProblem(problem);
        ideaDao.insertIdea(idea1);
        ideaDao.insertIdea(idea2);
        
        Idea_Problem ip1 = new Idea_Problem();
        Idea_Problem ip2 = new Idea_Problem();
        
        ip1.setProblem(problem);
        ip1.setIdea(idea1);
        
        ip2.setProblem(problem);
        ip2.setIdea(idea2);
        
        ipDao.insertIdea_Problem(ip1);
        ipDao.insertIdea_Problem(ip2);
        return problem;
    }
    Idea insertTwoIdea_ValuesSharingSameIdea(){
        Idea idea = insertAnIdea();
        Value problem1 = insertAValue();
        Value problem2 = insertAValue();
        
        Idea_Value iv1 = new Idea_Value();
        Idea_Value iv2 = new Idea_Value();
        
        iv1.setIdea(idea);
        iv1.setValue(problem1);
        
        iv2.setIdea(idea);
        iv2.setValue(problem2);
        
        ivDao.insertIdea_Value(iv1);
        ivDao.insertIdea_Value(iv2);
        return idea;
    }
    Value insertTwoIdea_ValuesSharingSameValue(){
        Value value = makeValueAndSetFields();
        Idea idea1 = makeIdeaAndSetFields();
        Idea idea2 = makeIdeaAndSetFields();
        
        valueDao.insertValue(value);
        ideaDao.insertIdea(idea1);
        ideaDao.insertIdea(idea2);
        
        Idea_Value iv1 = new Idea_Value();
        Idea_Value iv2 = new Idea_Value();
        
        iv1.setValue(value);
        iv1.setIdea(idea1);
        
        iv2.setValue(value);
        iv2.setIdea(idea2);
        
        ivDao.insertIdea_Value(iv1);
        ivDao.insertIdea_Value(iv2);
        return value;
    }
    Session insertTwoSession_ProblemsSharingSameSession(){
        Session session = insertASession();
        Problem problem1 = insertAProblem();
        Problem problem2 = insertAProblem();
        
        Session_Problem sp1 = new Session_Problem();
        Session_Problem sp2 = new Session_Problem();
        
        sp1.setSession(session);
        sp1.setProblem(problem1);
        
        sp2.setSession(session);
        sp2.setProblem(problem2);
        
        spDao.insertSession_Problem(sp1);
        spDao.insertSession_Problem(sp2);
        return session;
    }
    Problem insertTwoSession_ProblemsSharingSameProblem(){
        Problem problem = makeProblemAndSetFields();
        Session session1 = makeSessionAndSetFields();
        Session session2 = makeSessionAndSetFields();
        
        problemDao.insertProblem(problem);
        sessionDao.insertSession(session1);
        sessionDao.insertSession(session2);
        
        Session_Problem sp1 = new Session_Problem();
        Session_Problem sp2 = new Session_Problem();
        
        sp1.setProblem(problem);
        sp1.setSession(session1);
        
        sp2.setProblem(problem);
        sp2.setSession(session2);
        
        spDao.insertSession_Problem(sp1);
        spDao.insertSession_Problem(sp2);
        return problem;
    }
    
    Idea_Concept insertAnIdea_Concept(){
        Idea_Concept ic = makeIdea_ConceptAndSetFields();
        return icDao.insertIdea_Concept(ic);
    }
    
    Idea_Value insertAnIdea_Value(){
        Idea_Value iv = makeIdea_ValueAndSetFields();
        return ivDao.insertIdea_Value(iv);
    }
    
    Idea_Problem insertAnIdea_Problem(){
        Idea_Problem ip = makeIdea_ProblemAndSetFields();
        return ipDao.insertIdea_Problem(ip);
    }
    
    Session_Problem insertASession_Problem(){
        Session_Problem sp = makeSession_ProblemAndSetFields();
        return spDao.insertSession_Problem(sp);
    }
    
    Idea insertAnIdea(){
        Idea idea = makeIdeaAndSetFields();
        idea = ideaDao.insertIdea(idea);
        return idea;
    }
    
    Idea insertAnIdeaWithNullDescription(){
        Idea idea = new Idea();
        idea.setName("name");
        idea.setDescription(null);
        return ideaDao.insertIdea(idea);
    }
    
    Idea insertAnIdeaWithNullName(){
        Idea idea = new Idea();
        idea.setName(null);
        idea.setDescription("description");
        return ideaDao.insertIdea(idea);
    }
    
    Concept insertAConcept(){
        Concept concept = makeConceptAndSetFields();
        return conceptDao.insertConcept(concept);
    }
    
    Concept insertAConceptWithNullDescription(){
        Concept concept = new Concept();
        concept.setName("name");
        concept.setDescription(null);
        return conceptDao.insertConcept(concept);
    }
    
    Concept insertAConceptWithNullName(){
        Concept concept = new Concept();
        concept.setName(null);
        concept.setDescription("description");
        return conceptDao.insertConcept(concept);
    }
    
    Problem insertAProblem(){
        Problem problem = makeProblemAndSetFields();
        return problemDao.insertProblem(problem);
    }
    
    Problem insertAProblemWithNullDescription(){
        Problem problem = new Problem();
        problem.setName("name");
        problem.setDescription(null);
        return problemDao.insertProblem(problem);
    }
    
    Problem insertAProblemWithNullName(){
        Problem problem = new Problem();
        problem.setName(null);
        problem.setDescription("description");
        return problemDao.insertProblem(problem);
    }
    
    Value insertAValue(){
        Value value = makeValueAndSetFields();
        return valueDao.insertValue(value);
    }
    
    Value insertAValueWithNullDescription(){
        Value value = new Value();
        value.setName("name");
        value.setDescription(null);
        return valueDao.insertValue(value);
    }
    
    Value insertAValueWithNullName(){
        Value value = new Value();
        value.setName(null);
        value.setDescription("description");
        return valueDao.insertValue(value);
    }
    
    Session insertASession(){
        Session session = makeSessionAndSetFields();
        return sessionDao.insertSession(session);
    }
    
    Session insertASessionWithNullHatSequence(){
        Session session = new Session();
        session.setDate(LocalDate.parse("1992-05-14"));
        session.setStart_time(LocalTime.parse("12:15:00"));
        session.setEnd_time(LocalTime.parse("12:20:00"));
        session.setHat_sequence(null);
        return sessionDao.insertSession(session);
    }
    
    Session insertASessionWithNullDate(){
        Session session = new Session();
        session.setDate(null);
        session.setStart_time(LocalTime.parse("12:15:00"));
        session.setEnd_time(LocalTime.parse("12:20:00"));
        session.setHat_sequence("white,red,green,yellow,black,red,white");
        return sessionDao.insertSession(session);
    }
    
    Idea makeAndUpdateAnIdea(){
        Idea idea = insertAnIdea();
        
        String newName = "abc";
        String newDescription = "xyz";
        
        idea.setName(newName);
        idea.setDescription(newDescription);
        
        ideaDao.updateIdea(idea);
        
        return ideaDao.getIdeaById(idea.getId());
    }
    
    Concept makeAndUpdateAConcept(){
        Concept concept = insertAConcept();
        
        String newName = "abc";
        String newDescription = "xyz";
        
        concept.setName(newName);
        concept.setDescription(newDescription);
        
        conceptDao.updateConcept(concept);
        
        return conceptDao.getConceptById(concept.getId());
    }
    
    Value makeAndUpdateAValue(){
        Value value = insertAValue();
        
        String newName = "abc";
        String newDescription = "xyz";
        
        value.setName(newName);
        value.setDescription(newDescription);
        
        valueDao.updateValue(value);
        
        return valueDao.getValueById(value.getId());
    }
    
    Problem makeAndUpdateAProblem(){
        Problem problem = insertAProblem();
        
        String newName = "abc";
        String newDescription = "xyz";
        
        problem.setName(newName);
        problem.setDescription(newDescription);
        
        problemDao.updateProblem(problem);
        
        return problemDao.getProblemById(problem.getId());
    }
    
    private Idea_Concept makeIdea_ConceptAndSetFields(){
        Idea_Concept ic = new Idea_Concept();
        Idea idea = makeIdeaAndSetFields();
        Concept concept = makeConceptAndSetFields();
        ic.setIdea(idea);
        ic.setConcept(concept);
        return ic;
    }
    
    private Idea_Value makeIdea_ValueAndSetFields(){
        Idea_Value iv = new Idea_Value();
        Idea idea = makeIdeaAndSetFields();
        Value value = makeValueAndSetFields();
        iv.setIdea(idea);
        iv.setValue(value);
        return iv;
    }
    
    private Idea_Problem makeIdea_ProblemAndSetFields(){
        Idea_Problem ip = new Idea_Problem();
        Idea idea = makeIdeaAndSetFields();
        Problem problem = makeProblemAndSetFields();
        ip.setIdea(idea);
        ip.setProblem(problem);
        return ip;
    }
    
    private Session_Problem makeSession_ProblemAndSetFields(){
        Session_Problem sp = new Session_Problem();
        Session session = makeSessionAndSetFields();
        Problem problem = makeProblemAndSetFields();
        sp.setSession(session);
        sp.setProblem(problem);
        return sp;
    }
    
    private Idea makeIdeaAndSetFields(){
        Idea idea = new Idea();
        idea.setName("ABC");
        idea.setDescription("XYZ");
        
        return idea;
    }
    
    private Concept makeConceptAndSetFields(){
        Concept concept = new Concept();
        concept.setName("ABC");
        concept.setDescription("XYZ");
        
        return concept;
    }
    
    private Problem makeProblemAndSetFields(){
        Problem problem = new Problem();
        problem.setName("ABC");
        problem.setDescription("XYZ");
        
        return problem;
    }
    
    private Value makeValueAndSetFields(){
        Value value = new Value();
        value.setName("ABC");
        value.setDescription("XYZ");
        
        return value;
    }
    
    private Session makeSessionAndSetFields(){
        
        Session session = new Session();
        session.setDate(LocalDate.parse("1992-05-14"));
        session.setStart_time(LocalTime.parse("12:15:00"));
        session.setEnd_time(LocalTime.parse("12:20:00"));
        session.setHat_sequence("white,red,green,yellow,black,red,white");
        
        return session;
    }
}

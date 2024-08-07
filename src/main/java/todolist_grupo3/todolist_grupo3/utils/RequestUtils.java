package todolist_grupo3.todolist_grupo3.utils;


import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import todolist_grupo3.todolist_grupo3.domain.Response;

import java.time.LocalDateTime;
import java.util.Map;

import static org.apache.logging.log4j.util.Strings.EMPTY;

public class RequestUtils {
    /**
     * getResponse() method is the return body for UserController createUser() method
     * @param request
     * @param data
     * @param message
     * @param status
     * @return
     */
   public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status){
       return new Response(LocalDateTime.now().toString(),status.value(), request.getRequestURI()
               ,HttpStatus.valueOf(status.value()),message, EMPTY, data);
   }
}

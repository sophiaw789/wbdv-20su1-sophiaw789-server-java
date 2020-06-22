package com.example.assign5.repositories;

import java.util.List;
import com.example.assign5.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    @Query("SELECT widget FROM Widget widget WHERE widget.topic.id=:tid")
    public List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:wid")
    public Widget findWidgetById(@Param("wid") Integer widgetId);

    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();
}

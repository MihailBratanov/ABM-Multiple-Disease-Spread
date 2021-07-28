package abm_multiple_disease_spread;

import static abm_multiple_disease_spread.SocialActivity.*;
import static com.xj.anylogic.engine.HyperArray.*;
import static com.xj.anylogic.engine.UtilitiesArray.*;
import static com.xj.anylogic.engine.presentation.UtilitiesColor.*;
import static com.xj.anylogic.engine.presentation.UtilitiesDrawing.*;
import static java.lang.Math.*;

import com.xj.anylogic.engine.*;
import com.xj.anylogic.engine.Position;
import com.xj.anylogic.engine.analysis.*;
import com.xj.anylogic.engine.connectivity.*;
import com.xj.anylogic.engine.connectivity.ResultSet;
import com.xj.anylogic.engine.connectivity.Statement;
import com.xj.anylogic.engine.markup.*;
import com.xj.anylogic.engine.markup.DensityMap;
import com.xj.anylogic.engine.markup.Network;
import com.xj.anylogic.engine.markup.PedFlowStatistics;
import com.xj.anylogic.engine.presentation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Hospital extends Agent {

  // Parameters
  // Plain Variables

  public int capacity;

  // Collection Variables
  public java.util.ArrayList<Person> patients = new java.util.ArrayList<Person>();

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final short _STATECHART_ELEMENT_NEXT_ID_xjal = 0;

  // View areas
  public ViewArea _origin_VA = new ViewArea(
    this,
    "[Origin]",
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.SPECIFIED_ZOOM,
    1,
    100,
    100
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("_origin_VA", this._origin_VA);
    }
    return 1 + super.getViewAreas(_output);
  }

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle1 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle2 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int _group = 4;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 5;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  ShapeRectangle rectangle;
  ShapeRectangle rectangle1;
  ShapeRectangle rectangle2;
  ShapeGroup group;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rectangle =
      new ShapeRectangle(
        SHAPE_DRAW_2D3D,
        true,
        -12.0,
        -10.0,
        0.0,
        0.0,
        black,
        white,
        21.0,
        17.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    rectangle1 =
      new ShapeRectangle(
        SHAPE_DRAW_2D3D,
        true,
        -3.0,
        -7.0,
        0.0,
        0.0,
        red,
        red,
        3.0,
        12.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    rectangle2 =
      new ShapeRectangle(
        SHAPE_DRAW_2D3D,
        true,
        -9.0,
        0.0,
        0.0,
        4.71238898038469,
        red,
        red,
        3.0,
        14.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      group =
        new ShapeGroup(
          Hospital.this,
          SHAPE_DRAW_2D3D,
          true,
          0.0,
          10.0,
          0.0,
          0.0,
          rectangle,
          rectangle1,
          rectangle2
        );
    }
  }

  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

  ShapeTopLevelPresentationGroup presentation;
  ShapeGroup icon;

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape(int _shape) {
    switch (_shape) {
      case _presentation:
        return presentation;
      case _icon:
        return icon;
      case _rectangle:
        return rectangle;
      case _rectangle1:
        return rectangle1;
      case _rectangle2:
        return rectangle2;
      case _group:
        return group;
      default:
        return super.getPersistentShape(_shape);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal(Object _shape) {
    try {
      if (_shape == null) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, presentation, "presentation");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, icon, "icon");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle, "rectangle");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle1, "rectangle1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, rectangle2, "rectangle2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, group, "group");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        50,
        110,
        10,
        0,
        "capacity",
        capacity,
        false
      );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawCollection(_panel, _g, 50, 80, 10, 0, "patients", patients);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (_publicOnly) {
      return;
    }
    drawLinkToContainer(_panel, _g, 50, -100, 10, 0, "main", main);
    drawLinkToAgent(
      _panel,
      _g,
      50,
      -50,
      15,
      0,
      "connections",
      true,
      connections
    );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    super.drawModelElements(_panel, _g, _publicOnly, true);
    drawModelElements_PlainVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_CollectionVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_AgentLinks_xjal(_panel, _g, _publicOnly, _isSuperClass);
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (modelElementContains(_x, _y, 50, -100)) {
      if (_clickCount == 2) {
        _panel.browseAgent_xjal(50, -100, this, "main");
      } else {
        _panel.addInspect(50, -100, this, "main");
      }
      return true;
    }
    if (modelElementContains(_x, _y, 50, -50)) {
      _panel.addInspect_xjal(
        50,
        -50,
        this,
        "connections",
        Panel.INSPECT_CONNECTIONS_xjal
      );
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, 50, 110)) {
      _panel.addInspect(50, 110, this, "capacity");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_CollectionVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, 50, 80)) {
      _panel.addInspect(50, 80, this, "patients");
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (
      onClickModelAt_AgentLinks_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_PlainVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_CollectionVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    return super.onClickModelAt(_panel, _x, _y, _clickCount, _publicOnly, true);
  }

  /**
   * Constructor
   */
  public Hospital(
    Engine engine,
    Agent owner,
    AgentList<? extends Hospital> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(Hospital.class)) {
      instantiateBaseStructure_xjal();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Hospital() {}

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_Hospital_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(
        Hospital.this,
        true,
        0,
        0,
        0,
        0,
        group
      );
    icon = new ShapeGroup(Hospital.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(Hospital.class);
    if (isTopLevelClass_xjal(Hospital.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    if (isTopLevelClass_xjal(Hospital.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Hospital_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Hospital_xjal() {
    capacity = (int) triangular(464, 1120, 675);
  }

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if (owner instanceof Main) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient abm_multiple_disease_spread.Main main;

  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl(
    false,
    black,
    1.0,
    LINE_STYLE_SOLID,
    ARROW_NONE,
    0.0
  );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(
    this,
    _connections_commonAnimationSettings_xjal
  );

  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }

  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(
    boolean _underAgents_xjal,
    LinkToAgentAnimator _animator_xjal
  ) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if (_underAgents_xjal) {
      _animator_xjal.drawLink(this, connections, true, true);
    }
  }

  public AgentList<? extends Hospital> getPopulation() {
    return (AgentList<? extends Hospital>) super.getPopulation();
  }

  public List<? extends Hospital> agentsInRange(double distance) {
    return (List<? extends Hospital>) super.agentsInRange(distance);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -6185120187281436320L;
}

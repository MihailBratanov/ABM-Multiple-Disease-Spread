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

public class Workplace extends Agent {

  // Parameters

  // Collection Variables
  public java.util.ArrayList<Person> colleagues = new java.util.ArrayList<Person>();

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

  protected static final Color __ps287_Fill_Color = new Color(0x50000000, true);
  protected static final Color __ps288_Fill_Color = new Color(0xFFD13B00, true);
  protected static final Color __ps289_Fill_Color = new Color(0xFFF84000, true);
  protected static final Color __ps290_Fill_Color = new Color(0xFFBC2300, true);
  protected static final Color __ps291_Fill_Color = new Color(0xFFBC2300, true);
  protected static final Color __ps292_Fill_Color = new Color(0xFFF84000, true);
  protected static final Color __ps293_Fill_Color = new Color(0xFFBC2300, true);
  protected static final Color __ps294_Fill_Color = new Color(0xFF761200, true);
  protected static final Color __ps295_Fill_Color = new Color(0xFF761200, true);
  protected static final Color __ps296_Fill_Color = new Color(0xFF761200, true);
  protected static final Color __ps297_Line_Color = new Color(0xFF460800, true);

  @AnyLogicInternalCodegenAPI
  protected static final int __ps287 = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps288 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps289 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps290 = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps291 = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps292 = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps293 = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps294 = 8;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps295 = 9;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps296 = 10;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps297 = 11;

  @AnyLogicInternalCodegenAPI
  protected static final int _factory = 12;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 13;

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

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps287_pointsDX_xjal() {
    return new double[] {
      0.0,
      4.0,
      2.0,
      6.0,
      5.0,
      9.0,
      7.0,
      9.0,
      10.0,
      11.0,
      10.0,
      10.0,
      7.0,
      -2.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps287_pointsDY_xjal() {
    return new double[] {
      0.0,
      -1.0,
      -1.0,
      -2.0,
      -3.0,
      -3.0,
      -4.0,
      -4.0,
      -3.0,
      -4.0,
      -5.0,
      -5.0,
      -6.0,
      -1.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps287_pointsDZ_xjal() {
    return new double[] {
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps288_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 7.0, 7.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps288_pointsDY_xjal() {
    return new double[] { 0.0, -4.0, 0.0, 4.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps288_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps289_pointsDX_xjal() {
    return new double[] { 0.0, -2.0, -2.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps289_pointsDY_xjal() {
    return new double[] { 0.0, -1.0, 1.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps289_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps290_pointsDX_xjal() {
    return new double[] {
      0.0,
      0.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps290_pointsDY_xjal() {
    return new double[] {
      0.0,
      1.0,
      1.0,
      0.0,
      0.0,
      -6.0,
      -7.0,
      -8.0,
      -8.0,
      -7.0,
      -7.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps290_pointsDZ_xjal() {
    return new double[] {
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps291_pointsDX_xjal() {
    return new double[] {
      0.0,
      0.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps291_pointsDY_xjal() {
    return new double[] {
      0.0,
      1.0,
      1.0,
      0.0,
      0.0,
      -6.0,
      -7.0,
      -8.0,
      -8.0,
      -7.0,
      -7.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps291_pointsDZ_xjal() {
    return new double[] {
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps292_pointsDX_xjal() {
    return new double[] { 0.0, -7.0, -5.0, -4.0, -2.0, -1.0, 0.0, 7.0, 7.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps292_pointsDY_xjal() {
    return new double[] {
      0.0,
      -4.0,
      -8.0,
      -7.0,
      -9.0,
      -8.0,
      -10.0,
      -6.0,
      -4.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps292_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps293_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 7.0, 7.0, 5.0, 5.0, 2.0, 2.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps293_pointsDY_xjal() {
    return new double[] {
      0.0,
      -5.0,
      -9.0,
      -8.0,
      -10.0,
      -6.0,
      -9.0,
      -5.0,
      -8.0,
      -4.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps293_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps294_pointsDX_xjal() {
    return new double[] { 0.0, 1.0, 1.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps294_pointsDY_xjal() {
    return new double[] { 0.0, -1.0, -3.0, -2.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps294_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps295_pointsDX_xjal() {
    return new double[] { 0.0, 1.0, 1.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps295_pointsDY_xjal() {
    return new double[] { 0.0, -1.0, -3.0, -2.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps295_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps296_pointsDX_xjal() {
    return new double[] { 0.0, 1.0, 1.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps296_pointsDY_xjal() {
    return new double[] { 0.0, -1.0, -3.0, -2.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps296_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps297_pointsDX_xjal() {
    return new double[] {
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      -10.0,
      -10.0,
      -10.0,
      -18.0,
      -18.0,
      -18.0,
      -18.0,
      -18.0,
      -18.0,
      -15.0,
      -15.0,
      -15.0,
      -14.0,
      -14.0,
      -14.0,
      -13.0,
      -13.0,
      -13.0,
      -11.0,
      -11.0,
      -11.0,
      -10.0,
      -10.0,
      -10.0,
      -9.0,
      -9.0,
      -9.0,
      -9.0,
      -9.0,
      -9.0,
      -6.0,
      -6.0,
      -6.0,
      -6.0,
      -6.0,
      -6.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      -2.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps297_pointsDY_xjal() {
    return new double[] {
      0.0,
      0.0,
      4.0,
      4.0,
      4.0,
      9.0,
      9.0,
      9.0,
      5.0,
      5.0,
      5.0,
      1.0,
      1.0,
      1.0,
      -3.0,
      -3.0,
      -3.0,
      -2.0,
      -2.0,
      -2.0,
      -4.0,
      -4.0,
      -4.0,
      -3.0,
      -3.0,
      -3.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -5.0,
      -8.0,
      -9.0,
      -10.0,
      -10.0,
      -9.0,
      -8.0,
      -3.0,
      -3.0,
      -3.0,
      -3.0,
      -3.0,
      -3.0,
      -6.0,
      -7.0,
      -8.0,
      -8.0,
      -7.0,
      -6.0,
      -1.0,
      -1.0,
      -1.0,
      0.0,
    };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps297_pointsDZ_xjal() {
    return new double[] {
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
      0.0,
    };
  }

  ShapePolyLine _ps287;
  ShapePolyLine _ps288;
  ShapePolyLine _ps289;
  ShapeCurve _ps290;
  ShapeCurve _ps291;
  ShapePolyLine _ps292;
  ShapePolyLine _ps293;
  ShapePolyLine _ps294;
  ShapePolyLine _ps295;
  ShapePolyLine _ps296;
  ShapeCurve _ps297;
  ShapeGroup factory;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    _ps287 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        10.0,
        0.0,
        null,
        __ps287_Fill_Color,
        14,
        __ps287_pointsDX_xjal(),
        __ps287_pointsDY_xjal(),
        __ps287_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps288 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -10.0,
        5.0,
        0.0,
        null,
        __ps288_Fill_Color,
        4,
        __ps288_pointsDX_xjal(),
        __ps288_pointsDY_xjal(),
        __ps288_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps289 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        7.0,
        -1.0,
        0.0,
        null,
        __ps289_Fill_Color,
        3,
        __ps289_pointsDX_xjal(),
        __ps289_pointsDY_xjal(),
        __ps289_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps290 =
      new ShapeCurve(
        true,
        1.0,
        -3.0,
        null,
        __ps290_Fill_Color,
        12,
        true,
        __ps290_pointsDX_xjal(),
        __ps290_pointsDY_xjal(),
        true,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps291 =
      new ShapeCurve(
        true,
        5.0,
        -1.0,
        null,
        __ps291_Fill_Color,
        12,
        true,
        __ps291_pointsDX_xjal(),
        __ps291_pointsDY_xjal(),
        true,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps292 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        5.0,
        0.0,
        null,
        __ps292_Fill_Color,
        9,
        __ps292_pointsDX_xjal(),
        __ps292_pointsDY_xjal(),
        __ps292_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps293 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        8.0,
        0.0,
        null,
        __ps293_Fill_Color,
        10,
        __ps293_pointsDX_xjal(),
        __ps293_pointsDY_xjal(),
        __ps293_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps294 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        7.0,
        0.0,
        null,
        __ps294_Fill_Color,
        4,
        __ps294_pointsDX_xjal(),
        __ps294_pointsDY_xjal(),
        __ps294_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps295 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        2.0,
        6.0,
        0.0,
        null,
        __ps295_Fill_Color,
        4,
        __ps295_pointsDX_xjal(),
        __ps295_pointsDY_xjal(),
        __ps295_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps296 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        5.0,
        5.0,
        0.0,
        null,
        __ps296_Fill_Color,
        4,
        __ps296_pointsDX_xjal(),
        __ps296_pointsDY_xjal(),
        __ps296_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps297 =
      new ShapeCurve(
        true,
        7.0,
        -1.0,
        __ps297_Line_Color,
        null,
        54,
        true,
        __ps297_pointsDX_xjal(),
        __ps297_pointsDY_xjal(),
        true,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      factory =
        new ShapeGroup(
          Workplace.this,
          SHAPE_DRAW_2D,
          true,
          0.0,
          0.0,
          0.0,
          0.0,
          _ps287,
          _ps288,
          _ps289,
          _ps290,
          _ps291,
          _ps292,
          _ps293,
          _ps294,
          _ps295,
          _ps296,
          _ps297
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
      case __ps287:
        return _ps287;
      case __ps288:
        return _ps288;
      case __ps289:
        return _ps289;
      case __ps290:
        return _ps290;
      case __ps291:
        return _ps291;
      case __ps292:
        return _ps292;
      case __ps293:
        return _ps293;
      case __ps294:
        return _ps294;
      case __ps295:
        return _ps295;
      case __ps296:
        return _ps296;
      case __ps297:
        return _ps297;
      case _factory:
        return factory;
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
      _name_xjal = checkNameOfShape_xjal(_shape, _ps287, "_ps287");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps288, "_ps288");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps289, "_ps289");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps290, "_ps290");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps291, "_ps291");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps292, "_ps292");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps293, "_ps293");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps294, "_ps294");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps295, "_ps295");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps296, "_ps296");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps297, "_ps297");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, factory, "factory");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawCollection(_panel, _g, 40, 20, 10, 0, "colleagues", colleagues);
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
  private boolean onClickModelAt_CollectionVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, 40, 20)) {
      _panel.addInspect(40, 20, this, "colleagues");
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
  public Workplace(
    Engine engine,
    Agent owner,
    AgentList<? extends Workplace> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(Workplace.class)) {
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
  public Workplace() {}

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_Workplace_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(
        Workplace.this,
        true,
        0,
        0,
        0,
        0,
        factory
      );
    icon = new ShapeGroup(Workplace.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(Workplace.class);
    if (isTopLevelClass_xjal(Workplace.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    if (isTopLevelClass_xjal(Workplace.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Workplace_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Workplace_xjal() {}

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

  public AgentList<? extends Workplace> getPopulation() {
    return (AgentList<? extends Workplace>) super.getPopulation();
  }

  public List<? extends Workplace> agentsInRange(double distance) {
    return (List<? extends Workplace>) super.agentsInRange(distance);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = 623750607495419782L;
}
